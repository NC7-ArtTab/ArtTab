// profile.js

function centerProfileForm() {
    const container = document.querySelector('.profile-container');
    if (container) {
        const windowHeight = window.innerHeight;
        const containerHeight = container.offsetHeight;
        if (windowHeight > containerHeight) {
            const marginTop = (windowHeight - containerHeight) / 2;
            container.style.marginTop = marginTop + 'px';
        }
    }
}

window.addEventListener('resize', centerProfileForm);
window.addEventListener('load', centerProfileForm);
