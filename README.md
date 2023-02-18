---
#### TDD를 통해 TestCode 작성 방법을 배우지만 추구하고자 하는 개발 방식은 TDD가 아닙니다.


☄️ 학습 목표

🍏 이번 연습을 통해 아래 과정으로 개발 Cycle을 진행하고자 합니다.

1. Test Class를 만들고 해결해야 할 명세(요구사항)을 생성합니다.
2. Production Code를 작성해 요구사항을 풀어갑니다. 이 때, 최대한 결정적이며 부수효과가 없게 작성합니다.
3. 테스트 코드를 작성해 검증을 진행합니다.

🍏 Rest-assured Tool은 API를 재활용할 수 있습니다.

❗ Rest-assured를 사용할 때 주의할 점이 있습니다.
- Rest-assured를 사용할 경우 WAS를 띄웠을 때(SpringBoot On) API가 Caching이 됩니다.
- 만약 다른 테스트에서 동일한 API요청이 여러번 호출된다면 Test의 일관성을 보장할 수 없습니다. 즉, Test가 꼬일 수 있습니다.
- 따라서, **Test 격리**가 필요합니다. API의 초기화가 필요합니다.
