let nomPrenom = document.getElementById("exampleDataList")
console.log(nomPrenom)

let listeOrdo = document.querySelectorAll(".listeOrdo")
console.log(listeOrdo)

nomPrenom.addEventListener("change", () =>{
    console.log(nomPrenom.value);
        for (var i = 0; i < listeOrdo.length; i++){

            let colonnePatient = listeOrdo[i].querySelector(".patient span")
            console.log(colonnePatient.value)

            if (nomPrenom.value === colonnePatient.textContent.trim()) {
                listeOrdo[i].style.display = "inline";
            } else {
                listeOrdo[i].style.display = "none";
            }
        }
})
