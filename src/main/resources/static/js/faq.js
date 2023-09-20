// FAQ 목록 데이터 (이 예제에서는 임의의 데이터를 사용합니다)
const faqs = [
    {
        faqNo: 1,
        faqTitle: 'FAQ 제목 1',
        faqContent: 'FAQ 내용 1',
    },
    {
        faqNo: 2,
        faqTitle: 'FAQ 제목 2',
        faqContent: 'FAQ 내용 2',
    },
    // 추가 FAQ 항목들...
];

document.addEventListener('DOMContentLoaded', function () {
    const faqList = document.querySelector('#faq-list');

    // FAQ 목록을 렌더링하는 함수
    function renderFAQList() {
        faqs.forEach(function (faq) {
            const li = document.createElement('li');
            li.innerHTML = `
                <div class="faq-question" data-faq-no="${faq.faqNo}">
                    ${faq.faqTitle}
                </div>
                <div class="faq-answer" data-faq-no="${faq.faqNo}">
                    ${faq.faqContent}
                </div>
            `;
            faqList.appendChild(li);
        });

        // FAQ 질문 클릭 시 답변 펼치기/접기
        const faqQuestions = document.querySelectorAll('.faq-question');
        faqQuestions.forEach(function (question) {
            question.addEventListener('click', function () {
                const faqNo = this.getAttribute('data-faq-no');
                const answer = document.querySelector(`.faq-answer[data-faq-no="${faqNo}"]`);
                answer.classList.toggle('expanded');
            });
        });
    }

    renderFAQList();
});
