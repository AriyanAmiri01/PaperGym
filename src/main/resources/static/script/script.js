const sidebar = document.getElementById("sidebar");
const sidebarTab = document.getElementById("sidebarTab");
const backdrop = document.getElementById("navBackdrop");



function openSidebar() {
    sidebar.classList.add("open");
    backdrop.classList.add("open");

    sidebarTab.setAttribute("aria-expanded", "true");
    sidebarTab.setAttribute("aria-label", "Close navigation");

    document.querySelector(".sidebar-icon").textContent = "×";
}

function closeSidebar() {
    sidebar.classList.remove("open");
    backdrop.classList.remove("open");

    sidebarTab.setAttribute("aria-expanded", "false");
    sidebarTab.setAttribute("aria-label", "Open navigation");

    document.querySelector(".sidebar-icon").textContent = "☰";
}

function toggleSidebar() {
    if (sidebar.classList.contains("open")) {
        closeSidebar();
    } else {
        openSidebar();
    }
}

sidebarTab.addEventListener("click", toggleSidebar);
backdrop.addEventListener("click", closeSidebar);



