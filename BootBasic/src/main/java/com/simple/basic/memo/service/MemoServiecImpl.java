package com.simple.basic.memo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memoService")
public class MemoServiecImpl implements MemoService {

	@Autowired
	private MemoMapper memoMapper;
}
