async function clickSubmitImg() {
  // フォーム fetch
  // await fetch("http://localhost:8080", {
  //   method: "POST",
  //   headers: { "Content-Type": "application/x-www-form-urlencoded" },
  //   body: "content=csrfされました。",
  // });
  // JSON fetch
  await fetch("http://localhost:8080", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({content: "jsonでcsrfされました。"}),
  });
  // await browser.downloads.download("./cat.jpg");
}
