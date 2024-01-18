let Nom = document.getElementById("exampleDataList");
console.log(Nom)

Nom.addEventListener("input", () => {
    let valeurActuelle = Nom.value;
    console.log(valeurActuelle)
});