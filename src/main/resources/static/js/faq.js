document.addEventListener("DOMContentLoaded", function () {
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

                    // FAQ 내용이 이미 생성되어 있는 경우에는 숨깁니다.
                    if (this.classList.contains("active")) {
                        hideContent();
                    } else {
                        // FAQ 내용을 보여줍니다.
                        showContent(content);
                    }

                    // FAQ 항목의 활성 상태를 토글합니다.
                    this.classList.toggle("active");
                });

                faqList.appendChild(faqItem);
            });
        })
        .catch(error => {
            console.error("FAQ 데이터를 가져오는 중 오류 발생:", error);
        });
}

function showContent(content) {
    // FAQ 내용을 생성하고 표시합니다.
    const contentElement = document.createElement("div");
    contentElement.classList.add("faq-content");
    contentElement.textContent = content;
    contentElement.id = "faq-content";

    // FAQ 목록 아래에 콘텐트 요소를 추가합니다.
    const faqList = document.getElementById("faq-list");
    faqList.appendChild(contentElement);
}

function hideContent() {
    // FAQ 내용을 숨깁니다.
    const contentElement = document.getElementById("faq-content");
    if (contentElement) {
        contentElement.remove();
    }
}
