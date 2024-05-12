package org.sopt.now.advanced.team2android.domain.usecase

import org.sopt.now.advanced.team2android.domain.entity.MemberEntity
import org.sopt.now.advanced.team2android.domain.repository.MemberRepository

class SaveMemberDataUseCase(private val memberRepository: MemberRepository) {
    suspend operator fun invoke(memberEntity: MemberEntity) =
        memberRepository.saveMemberData(memberEntity = memberEntity)
}