let text = localStorage.getItem("ocrText") || "";

let alerts = [];
let alternatives = [];

// SIMPLE RULE-BASED CHECK
if (text.toLowerCase().includes("sugar")) {
    alerts.push("⚠ High Sugar Detected");
    alternatives.push("Choose low-sugar cereals or granola.");
}
if (text.toLowerCase().includes("salt") || text.includes("sodium")) {
    alerts.push("⚠ High Salt/Sodium Detected");
    alternatives.push("Try low-sodium snacks.");
}
if (text.toLowerCase().includes("fat")) {
    alerts.push("⚠ High Fat Detected");
    alternatives.push("Pick baked/air-fried alternatives.");
}

document.getElementById("alertList").innerHTML =
    alerts.map(a => `<li>${a}</li>`).join("");

document.getElementById("alternativeList").innerHTML =
    alternatives.map(a => `<li>${a}</li>`).join("");
