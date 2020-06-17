package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Member;
import com.example.repository.MemberRepository;

@Service
@Transactional
public class MemberService {
	@Autowired
	private MemberRepository repository;

	public List<Member> findByName(String partOfName) {
		return repository.findByName(partOfName);
	}
}
