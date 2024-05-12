package org.sopt.now.advanced.team2android.domain.usecase

import kotlinx.coroutines.flow.Flow
import org.sopt.now.advanced.team2android.domain.repository.MemberRepository

class GetPwUseCase(private val memberRepository: MemberRepository) {
    operator fun invoke(): Flow<String> = memberRepository.pw
}