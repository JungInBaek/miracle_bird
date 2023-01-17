package com.multi.miraclebird.weka;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Random;

import org.springframework.stereotype.Service;

import weka.classifiers.Classifier;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.CSVLoader;

@Service
public class recommendService {

	public String recommend(double[] values, String path) throws Exception {
		// 1. 데이터 로딩(수집)
		String file = path + "data\\recommend.csv";
		System.out.println("file: " + file);
		CSVLoader loader = new CSVLoader();
		loader.setSource(new File(file));
		Instances data = loader.getDataSet(); // arff형식으로 변환해서 가지고 온다.

		// 모델을 읽어와서, test데이터에 있는 것 꺼내서 검증해보자.
		Classifier model = (Classifier) SerializationHelper.read(path + "\\model\\recommend.model");

		// 1. Attribute리스트를 만들자.
		ArrayList attributes = new ArrayList<>();

		// 2. attributes리스트를 만들어서 Instances객체에 셋팅
		Enumeration<Attribute> attr_list = data.enumerateAttributes();

		while (attr_list.hasMoreElements()) {
			attributes.add(attr_list.nextElement());
		}
		System.out.println(attributes); // [attr, attr, attr, attr, attr, ..]

		// 3. arff를 나타내는 Instances객체를 만들자.
		Instances instances = new Instances("test", attributes, 0);
		instances.setClassIndex(instances.numAttributes() - 1);

		// 4. 분류할 데이터의 값들을 double[]에 넣어주자.!
		instances.add(new DenseInstance(1, values));

		System.out.println("=== 여기까지 만든 arff(instances) 확인 ===");
		System.out.println(instances);

		// 5. read해온 model로 위에서 만든 사람을 분류해보자.
		double result = model.classifyInstance(instances.firstInstance());

		System.out.println("============== 분류기의 결과>> " + result);
		if (result != 0) { // 내향
			System.out.println("내향");
		} else {
			System.out.println("외향");
		}
		System.out.println("============== 추천내용 ============");
		String[] in = { "휴식", "독서", "게임", "공부" };

		String[] out = { "헬스", "여행", "모임", "공연" };

		System.out.println("result>> " + result);

		Random r = new Random();
		int index = r.nextInt(4);
		if (result != 0) {
			return in[index];
		} else {
			return out[index];
		}

	}

}
