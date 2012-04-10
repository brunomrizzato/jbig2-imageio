/**
 * Copyright (C) 1995-2010 levigo holding gmbh.
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

package com.levigo.jbig2;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.stream.ImageInputStream;

import com.levigo.jbig2.io.DefaultInputStreamFactory;

public class JBIG2ImageReaderDemo {

  private String filepath;
  private int imageIndex;

  public JBIG2ImageReaderDemo(String filepath, int imageIndex) {
    this.filepath = filepath;
    this.imageIndex = imageIndex;
  }

  public void show() throws IOException {
    InputStream inputStream = getClass().getResourceAsStream(filepath);
    DefaultInputStreamFactory disf = new DefaultInputStreamFactory();
    ImageInputStream imageInputStream = disf.getInputStream(inputStream);

    JBIG2ImageReader imageReader = new JBIG2ImageReader(new JBIG2ImageReaderSpi(), true);

    imageReader.setInput(imageInputStream);
    JBIG2ReadParam param = imageReader.getDefaultReadParam();

    long timeStamp = System.currentTimeMillis();
    BufferedImage bufferedImage = imageReader.read(imageIndex, param);
    long duration = System.currentTimeMillis() - timeStamp;
    System.out.println(filepath + " decoding took " + duration + " ms");

    new TestImage(bufferedImage);
  }

  public static void main(String[] args) throws IOException {
    JBIG2ImageReaderDemo demo = new JBIG2ImageReaderDemo("/images/042_1.jb2", 0);
    demo.show();
  }

}