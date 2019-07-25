/*
 * Copyright (C) 2016 yydcdut (yuyidong2015@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.yydcdut.markdown.live;

import android.text.Editable;
import android.text.style.AlignmentSpan;

import com.yydcdut.markdown.syntax.Syntax;
import com.yydcdut.markdown.syntax.SyntaxKey;
import com.yydcdut.markdown.syntax.edit.EditFactory;
import com.yydcdut.markdown.utils.SyntaxUtils;
import com.yydcdut.markdown.utils.TextHelper;

import java.util.List;

/**
 * RxMDEditText, center align controller.
 * <p>
 * Created by yuyidong on 16/7/22.
 */
class CenterAlignLive extends EditLive {

    @Override
    public void beforeTextChanged(CharSequence s, int start, int before, int after) {
        super.beforeTextChanged(s, start, before, after);
        if (before == 0 || mMarkdownConfiguration == null) {
            return;
        }
        if (isNeedFormat(s.subSequence(TextHelper.safePosition(start, s), TextHelper.safePosition(start + before, s)).toString())) {
            shouldFormat = true;
        }
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int after) {
        if (mMarkdownConfiguration == null || !(s instanceof Editable)) {
            return;
        }
        if (shouldFormat) {
            format((Editable) s, start);
            return;
        }
        if (after == 0) {
            return;
        }
        if (isNeedFormat(s.subSequence(TextHelper.safePosition(start, s), TextHelper.safePosition(start + after, s)).toString())) {
            format((Editable) s, start);
        }
    }

    private void format(Editable editable, int start) {
        SyntaxUtils.removeSpans(editable, start, AlignmentSpan.Standard.class);
        Syntax syntax = EditFactory.create().getCenterAlignSyntax(mMarkdownConfiguration);
        List<EditToken> editTokenList = SyntaxUtils.getMatchedEditTokenList(editable, syntax.format(editable), start);
        SyntaxUtils.setSpans(editable, editTokenList);
    }

    private boolean isNeedFormat(String string) {
        return string.contains(SyntaxKey.KEY_CENTER_ALIGN_LEFT) || string.contains(SyntaxKey.KEY_CENTER_ALIGN_RIGHT);
    }
}