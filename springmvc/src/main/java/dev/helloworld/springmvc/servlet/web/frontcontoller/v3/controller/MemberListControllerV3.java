package dev.helloworld.springmvc.servlet.web.frontcontoller.v3.controller;

import dev.helloworld.springmvc.servlet.domain.member.Member;
import dev.helloworld.springmvc.servlet.domain.member.MemberRepository;
import dev.helloworld.springmvc.servlet.web.frontcontoller.ModelView;
import dev.helloworld.springmvc.servlet.web.frontcontoller.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        List<Member> members = memberRepository.findAll();
        ModelView mv = new ModelView("members");
        mv.getModel().put("members", members);
        return mv;
    }
}
