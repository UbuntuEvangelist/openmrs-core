/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.obs;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openmrs.obs.handler.MediaHandler;


public class MediaHandlerTest {

    @Test
    public void shouldReturnSupportedViews() {
        MediaHandler handler = new MediaHandler();
        String[] actualViews = handler.getSupportedViews();
        String[] expectedViews = { ComplexObsHandler.RAW_VIEW };

        assertArrayEquals(actualViews, expectedViews);
    }

    @Test
    public void shouldSupportRawView() {
        MediaHandler handler = new MediaHandler();

        assertTrue(handler.supportsView(ComplexObsHandler.RAW_VIEW));
    }

    @Test
    public void shouldNotSupportOtherViews() {
        MediaHandler handler = new MediaHandler();

        assertFalse(handler.supportsView(ComplexObsHandler.HTML_VIEW));
        assertFalse(handler.supportsView(ComplexObsHandler.PREVIEW_VIEW));
        assertFalse(handler.supportsView(ComplexObsHandler.TEXT_VIEW));
        assertFalse(handler.supportsView(ComplexObsHandler.TITLE_VIEW));
        assertFalse(handler.supportsView(ComplexObsHandler.URI_VIEW));
        assertFalse(handler.supportsView(""));
        assertFalse(handler.supportsView((String) null));
    }
}
