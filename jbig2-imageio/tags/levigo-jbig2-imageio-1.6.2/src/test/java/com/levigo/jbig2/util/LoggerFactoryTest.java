/**
 * Copyright (C) 1995-2014 levigo holding gmbh.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.levigo.jbig2.util;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.levigo.jbig2.util.log.LoggerBridge;
import com.levigo.jbig2.util.log.LoggerFactory;

public class LoggerFactoryTest {

  @Test
  public void testWithDefaultClassLoader() {
    LoggerFactory.setClassLoader(LoggerBridge.class.getClassLoader());
    assertNotNull(LoggerFactory.getLogger(LoggerFactoryTest.class));
  }
  
  @Test
  public void testWithContextClassLoader() {
    LoggerFactory.setClassLoader(Thread.currentThread().getContextClassLoader());
    assertNotNull(LoggerFactory.getLogger(LoggerFactoryTest.class));
  }
  

}
