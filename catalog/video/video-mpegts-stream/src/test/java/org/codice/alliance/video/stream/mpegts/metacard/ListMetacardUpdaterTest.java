/**
 * Copyright (c) Codice Foundation
 *
 * <p>This is free software: you can redistribute it and/or modify it under the terms of the GNU
 * Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or any later version.
 *
 * <p>This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details. A copy of the GNU Lesser General Public
 * License is distributed along with this program and can be found at
 * <http://www.gnu.org/licenses/lgpl.html>.
 */
package org.codice.alliance.video.stream.mpegts.metacard;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import ddf.catalog.data.Metacard;
import java.util.Arrays;
import java.util.Collections;
import org.codice.alliance.video.stream.mpegts.Context;
import org.junit.Test;

public class ListMetacardUpdaterTest {

  @Test
  public void testUpdate() {

    MetacardUpdater updater1 = mock(MetacardUpdater.class);
    MetacardUpdater updater2 = mock(MetacardUpdater.class);

    ListMetacardUpdater listMetacardUpdater =
        new ListMetacardUpdater(Arrays.asList(updater1, updater2));

    Metacard parent = mock(Metacard.class);
    Metacard child = mock(Metacard.class);

    Context context = mock(Context.class);

    listMetacardUpdater.update(parent, child, context);

    verify(updater1).update(parent, child, context);
    verify(updater2).update(parent, child, context);
  }

  @Test
  public void testToString() {
    ListMetacardUpdater listMetacardUpdater = new ListMetacardUpdater(Collections.emptyList());
    assertThat(listMetacardUpdater.toString(), notNullValue());
  }
}
