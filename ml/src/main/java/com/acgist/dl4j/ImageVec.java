package com.acgist.dl4j;

import org.datavec.api.records.reader.RecordReader;
import org.datavec.api.split.InputStreamInputSplit;
import org.datavec.image.recordreader.ImageRecordReader;

public class ImageVec {

	public static void main(String[] args) {
		try(RecordReader reader = new ImageRecordReader(750, 500)) {
			reader.initialize(new InputStreamInputSplit(ImageVec.class.getResourceAsStream("/image/a.jpg")));
			System.out.println(reader.hasNext());
			System.out.println(reader.next());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
