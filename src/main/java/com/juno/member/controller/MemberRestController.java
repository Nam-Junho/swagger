package com.juno.member.controller;

import com.juno.member.entity.Member;
import com.juno.member.repository.MemberRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Member v1")
@RequestMapping("/api/v1")
public class MemberRestController {

	@Autowired
	private MemberRepository memberRepository;

	@GetMapping(value = "/members")
	@ApiOperation(value = "Finds Pets by status",
			notes = "Multiple status values can be provided with comma seperated strings",
			response = Member.class,
			responseContainer = "List")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid ID supplied"),
			@ApiResponse(code = 404, message = "Pet not found") })
	public List<Member> findMembers(){
		return memberRepository.findAll();
	}

	@GetMapping(value = "/member/{idx}")
	public Member findMember(@PathVariable long idx){
		return memberRepository.findById(idx).orElseThrow();
	}

	@PostMapping(value = "/member")
	public Member saveMember(@RequestBody Member member){
		return memberRepository.save(member);
	}

	@PutMapping(value = "/member")
	public Member updateMember(@RequestBody Member member){
		return memberRepository.save(member);
	}

	@DeleteMapping(value = "/member/{idx}")
	public String deleteMember(@PathVariable long idx){
		memberRepository.deleteById(idx);
		return "delete";
	}
}
