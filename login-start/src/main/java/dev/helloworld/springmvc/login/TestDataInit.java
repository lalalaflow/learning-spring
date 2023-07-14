package dev.helloworld.springmvc.login;

import dev.helloworld.springmvc.login.domain.item.Item;
import dev.helloworld.springmvc.login.domain.item.ItemRepository;
import dev.helloworld.springmvc.login.domain.member.Member;
import dev.helloworld.springmvc.login.domain.member.MemberRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;

    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        itemRepository.save(new Item("itemA", 10000, 10));
        itemRepository.save(new Item("itemB", 20000, 20));

        Member member = new Member();
        member.setLoginId("test");
        member.setPassword("test!");
        member.setName("ㅌㅔ스터");

        memberRepository.save(member);
    }

}