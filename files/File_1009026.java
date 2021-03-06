/* NOTICE: This file has been changed by Plutext Pty Ltd for use in docx4j.
 * The package name has been changed; there may also be other changes.
 * 
 * This notice is included to meet the condition in clause 4(b) of the License. 
 */
 
 /**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.docx4j.org.apache.xml.security.utils;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * This {@link org.xml.sax.ErrorHandler} does absolutely nothing but log
 * the events.
 *
 * @author Christian Geuer-Pollmann
 */
public class IgnoreAllErrorHandler implements ErrorHandler {

    private static final org.slf4j.Logger log =
        org.slf4j.LoggerFactory.getLogger(IgnoreAllErrorHandler.class);

    /** Field throwExceptions */
    private static final boolean warnOnExceptions =
        getProperty("org.docx4j.org.apache.xml.security.test.warn.on.exceptions");

    /** Field throwExceptions           */
    private static final boolean throwExceptions = 
        getProperty("org.docx4j.org.apache.xml.security.test.throw.exceptions");

    private static boolean getProperty(final String name) {
        return java.security.AccessController.doPrivileged(
                new java.security.PrivilegedAction<Boolean>() {

                    @Override
                    public Boolean run() {
                        return Boolean.getBoolean(name);
                    }
                });
    }

    /** @inheritDoc */
    @Override
    public void warning(SAXParseException ex) throws SAXException {
        if (IgnoreAllErrorHandler.warnOnExceptions) {
            log.warn("", ex);
        }
        if (IgnoreAllErrorHandler.throwExceptions) {
            throw ex;
        }
    }


    /** @inheritDoc */
    @Override
    public void error(SAXParseException ex) throws SAXException {
        if (IgnoreAllErrorHandler.warnOnExceptions) {
            log.error("", ex);
        }
        if (IgnoreAllErrorHandler.throwExceptions) {
            throw ex;
        }
    }


    /** @inheritDoc */
    @Override
    public void fatalError(SAXParseException ex) throws SAXException {
        if (IgnoreAllErrorHandler.warnOnExceptions) {
            log.warn("", ex);
        }
        if (IgnoreAllErrorHandler.throwExceptions) {
            throw ex;
        }
    }
}
