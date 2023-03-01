package dev.helloworld.springmvc.servlet.web.frontcontoller.v3.controller;

import dev.helloworld.springmvc.servlet.domain.member.Member;
import dev.helloworld.springmvc.servlet.domain.member.MemberRepository;
import dev.helloworld.springmvc.servlet.web.frontcontoller.ModelView;
import dev.helloworld.springmvc.servlet.web.frontcontoller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public ModelView process(Map<String, String> paramMap) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelView mv = new ModelView("save-result");
        mv.getModel().put("member", member);
        return mv;
    }
}
