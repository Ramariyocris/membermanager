package tech.developer.membermanager.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.developer.membermanager.model.Member;
import tech.developer.membermanager.service.MemberService;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberResource {
    private final MemberService memberService;

    public MemberResource(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Member>> getAllMembers () {
        List<Member> members = memberService.findAllMembers();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Member> getMemberById (@PathVariable("id") Long id) {
        Member member = memberService.findMemberById(id);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Member> addMember(@RequestBody Member member) {
        Member newMember = memberService.addMember(member);
        return new ResponseEntity<>(newMember, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Member> updateMember(@RequestBody Member member) {
        Member updateMember = memberService.updateMember(member);
        return new ResponseEntity<>(updateMember, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable("id") Long id) {
        memberService.deleteMember(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
