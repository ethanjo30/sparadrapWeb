let nomPrenom = document.getElementById("exampleDataList")
console.log(nomPrenom)
let listeOrdo = document.querySelectorAll(".listeOrdo tr")

nomPrenom.addEventListener("change", () =>{
        for (const row of listeOrdo){

            let nomPatient = row.querySelector(".nom ")

            if (nomPrenom.value === nomPatient.innerText) {
                row.style.display = "";
            } else {
                row.style.display = "none";
            }
        }
})