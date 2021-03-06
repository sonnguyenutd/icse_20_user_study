/*
 * Copyright 2017 LINE Corporation
 *
 * LINE Corporation licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.linecorp.armeria.client.encoding;

import com.linecorp.armeria.common.HttpData;
import com.linecorp.armeria.unsafe.ByteBufHttpData;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.compression.ZlibCodecFactory;
import io.netty.handler.codec.compression.ZlibWrapper;

/**
 * A {@link StreamDecoder} that user zlib ('gzip' or 'deflate'). Netty implementation used to allow
 * for incremental decoding using an {@link EmbeddedChannel}.
 */
class ZlibStreamDecoder implements StreamDecoder {

    private final EmbeddedChannel decoder;

    ZlibStreamDecoder(ZlibWrapper zlibWrapper, ByteBufAllocator alloc) {
        decoder = new EmbeddedChannel(false, ZlibCodecFactory.newZlibDecoder(zlibWrapper));
        decoder.config().setAllocator(alloc);
    }

    @Override
    public HttpData decode(HttpData obj) {
        if (obj instanceof ByteBufHolder) {
            decoder.writeInbound(((ByteBufHolder) obj).content());
        } else {
            final ByteBuf compressed = Unpooled.wrappedBuffer(obj.array());
            decoder.writeInbound(compressed);
        }
        return fetchDecoderOutput();
    }

    @Override
    public HttpData finish() {
        if (decoder.finish()) {
            return fetchDecoderOutput();
        } else {
            return HttpData.EMPTY_DATA;
        }
    }

    // Mostly copied from netty's HttpContentDecoder.
    private HttpData fetchDecoderOutput() {
        ByteBuf decoded = null;
        for (;;) {
            final ByteBuf buf = decoder.readInbound();
            if (buf == null) {
                break;
            }
            if (!buf.isReadable()) {
                buf.release();
                continue;
            }
            if (decoded == null) {
                decoded = buf;
            } else {
                try {
                    decoded.writeBytes(buf);
                } finally {
                    buf.release();
                }
            }
        }

        if (decoded == null) {
            return HttpData.EMPTY_DATA;
        }

        return new ByteBufHttpData(decoded, false);
    }
}
