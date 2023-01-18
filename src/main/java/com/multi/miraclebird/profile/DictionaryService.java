package com.multi.miraclebird.profile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;

@Service
public class DictionaryService {

	@Autowired
	DictionaryDAO dictionaryDAO;

	public int emotion(String sentence, String path) {
		
		Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);
		
		KomoranResult komoranResult = komoran.analyze(sentence); // 단어 분석 결과
		List<String> nounList = komoranResult.getNouns(); // 명사 목록만 추출
		System.out.println("명사 목록" + nounList);
		
		System.out.println();

		//stopWords만들기 
		HashSet<String> stopWords = new HashSet<>();

		try {
			BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(path + "data\\stop.txt")));
			String line = null;
//			 System.out.println(buffer.readLine());
			while ((line = buffer.readLine()) != null) {
				if (line.trim().length() > 0) {
					stopWords.add(line.trim());
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
//		System.out.println("금칙어" + stopWords); //stopWords프린트 
//		System.out.println(stopWords.size());
		
		//금칙어 제외처리
		List<String> nounList2 = new ArrayList<String>();
		for (String s : nounList) {
			if(stopWords.contains(s)) {
				continue;
			}
			nounList2.add(s);
		}
		//금칙어 제외된 명사목록 
		System.out.println("제외된 명사 목록" + nounList2);
		
		int sum = 0;
		for (String word : nounList2) {
			DictionaryVO vo = dictionaryDAO.one(word);
			if(vo != null) { //사전에 없는 단어일수도 있으므로 
				sum += vo.getJumsu();
			}
		}
		
		System.out.println(sum);
		return sum;
	}
}