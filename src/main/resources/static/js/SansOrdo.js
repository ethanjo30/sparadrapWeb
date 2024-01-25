let patient = document.getElementById("patient")

let medicament = document.getElementById("medicament")

let listmedicament = document.querySelectorAll(".listmedicament")

let data = document.querySelectorAll("#datalistMedicament option")

medicament.addEventListener("change", () => {
    if(medicament.value !== "") {
        let categorie
        let prix
        let nom = medicament.value

        for (const row of data){
            if (medicament.value===row.innerText){
                categorie = row.getAttribute("cate_Med");
                prix = row.getAttribute("prix_Med");
            }
        }
        
        let newRow = document.createElement("tr");

        newRow.innerHTML = `
            <td class="nomMed">${nom}</td>
            <td class="catMed">${categorie}</td>
            <td class="prixMed">${prix} €</td>
            <td class="quantite"><input class="form-control quantite" value="1"></td>
            <td class="total"></td>`;

            listmedicament.forEach(element => {
                element.appendChild(newRow.cloneNode(true));
            });
        
        let prixMedicament = document.querySelector(".prixMed")
        console.log(prixMedicament.value)
    }
}); 