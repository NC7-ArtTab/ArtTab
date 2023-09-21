document.addEventListener("DOMContentLoaded", function () {
    console.log(document.getElementById("faq-list"))
    // 서버에서 FAQ 목록을 가져오는 함수를 호출하고 목록을 생성합니다.
    loadFAQList();
});

function loadFAQList() {
    // 서버에서 FAQ 목록을 가져오는 비동기 요청을 보냅니다.
    fetch("/api/faq")
        .then(response => response.json())
        .then(data => {
            const faqList = document.getElementById("faq-list");

            // FAQ 목록을 순회하며 각 항목을 생성합니다.
            data.forEach(faq => {
                const faqItem = document.createElement("li");
                faqItem.classList.add("faq-item");
                faqItem.textContent = faq.faqTitle;
                faqItem.dataset.content = faq.faqContent;

                // FAQ 항목을 클릭할 때 이벤트 리스너를 추가합니다.
                faqItem.addEventListener("click", function () {
                    const content = this.dataset.content;
                    alert(content); // 나중에는 모달 또는 다른 방법으로 표시할 수 있습니다.
                });

                faqList.appendChild(faqItem);
            });
        })
        .catch(error => {
            console.error("FAQ 데이터를 가져오는 중 오류 발생:", error);
        });
}
