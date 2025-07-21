async function clickSubmitImg() {
  fetch("http://localhost:8080", {
    method: "POST",
    body: JSON.stringify({ content: "csrfされました。" }),
  });
  browser.downloads.download("./cat.jpg");
}
