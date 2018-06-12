package com.acgist.begin.regression;

import java.util.ArrayList;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.mllib.linalg.Vectors;
import org.apache.spark.mllib.regression.LabeledPoint;
import org.apache.spark.mllib.regression.LinearRegressionModel;
import org.apache.spark.mllib.regression.LinearRegressionWithSGD;
import org.junit.Before;
import org.junit.Test;

public class LineTest {
	private SparkConf conf;
	private JavaSparkContext context;
	private List<LabeledPoint> list;

	@Before
	public void init() {
		conf = new SparkConf().setAppName("test").setMaster("local");
		context = new JavaSparkContext(conf);
		list = new ArrayList<>();
		list.add(new LabeledPoint(1.0, Vectors.dense(1D, 0D)));
		list.add(new LabeledPoint(2.0, Vectors.dense(1D, 1D)));
		list.add(new LabeledPoint(3.0, Vectors.dense(1D, 2D)));
		list.add(new LabeledPoint(4.0, Vectors.dense(1D, 3D)));
	}
	
	@Test
	public void line() {
		// 线性回归伴生对象
//		LinearRegressionWithSGD.train(arg0, arg1)
		// 线性回归类
//		LinearRegressionWithSGD sgd = new LinearRegressionWithSGD(1D, 100, 0D, 1D);
//		LinearRegressionModel model = sgd.run(input);
		
		JavaRDD<LabeledPoint> rdd = context.parallelize(list, 2);
		LinearRegressionModel model = LinearRegressionWithSGD.train(rdd.rdd(), 100, 1, 1);
		model.weights();
		model.intercept();
		
		double result = model.predict(Vectors.dense(1D, 40D));
		System.out.println("结果：" + result);
		
//		model.save(sc, path); // 保存模型
	}
	
}
