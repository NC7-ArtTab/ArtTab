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

                const titleElement = document.createElement("div");
                titleElement.classList.add("faq-title");
                titleElement.textContent = faq.faqTitle;

                const contentElement = document.createElement("div");
                contentElement.classList.add("faq-content");
                contentElement.textContent = faq.faqContent;
                contentElement.style.display = "none"; // 초기에는 숨깁니다.

                // FAQ 제목을 클릭할 때 이벤트 리스너를 추가합니다.
                titleElement.addEventListener("click", function () {
                    if (contentElement.style.display === "none") {
                        contentElement.style.display = "block"; // FAQ 내용을 보여줍니다.
                        titleElement.style.color = "red"; // FAQ 제목 색상 변경 (예시: 빨간색)
                    } else {
                        contentElement.style.display = "none"; // FAQ 내용을 숨깁니다.
                        titleElement.style.color = "black"; // FAQ 제목 색상 원래대로 변경
                    }
                });

                faqItem.appendChild(titleElement);
                faqItem.appendChild(contentElement);

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