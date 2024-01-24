let patient = document.getElementById("patient")

let medicament = document.getElementById("medicament")

let listmedicament = document.querySelectorAll(".listmedicament")

let table = document.querySelector("#tableAchat tbody")

if (medicament != null){
   /* ajouter du nom du medicament selectionner */

    medicament.addEventListener("input", () => {

        if(medicament.value !== "") {
           tbody = document.querySelector(".listmedicament")
           tbody.innerHTML = "<tr th:each='medicament: ${medicaments}'>";
           tbody.innerHTML = "<td><span th:text='${medicament.nom_Med}'></span></td>";
           tbody.innerHTML = "<td><span th:text='${medicament.cate_Med}'></span></td>";

            let nouvelleLigne = table.insertRow();
            let cellnom = nouvelleLigne.insertCell(0);

            cellnom.textContent = medicament.value;
        }
    });
}