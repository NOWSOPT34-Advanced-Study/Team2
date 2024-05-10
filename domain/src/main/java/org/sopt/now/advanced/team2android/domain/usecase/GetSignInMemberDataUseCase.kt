package org.sopt.now.advanced.team2android.domain.usecase

import org.sopt.now.advanced.team2android.domain.entity.MemberEntity
import org.sopt.now.advanced.team2android.domain.repository.MemberRepository

class GetSignInMemberDataUseCase(private val memberRepository: MemberRepository) {
    operator fun invoke(id: String, pw: String): Result<MemberEntity> =
        memberRepository.getSignInMemberData(id, pw)
}