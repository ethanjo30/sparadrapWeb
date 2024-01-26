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
                prix = parseFloat(row.getAttribute("prix_Med"));
            }
        }
        
        let newRow = document.createElement("tr");

        newRow.innerHTML = `
            <td class="nomMed">${nom}</td>
            <td class="catMed">${categorie}</td>
            <td class="prixMed">${prix} €</td>
            <td class="quantite"><input value="1"></td>
            <td class="total">${prix} €</td>`;

            listmedicament.forEach(element => {
                element.appendChild(newRow.cloneNode(true));
            });

            let colQuantite = newRow.querySelector(".quantite input");
            let colTotal = newRow.querySelector(".total");

            console.log(colQuantite.value)
            console.log(colTotal.textContent)
            console.log(prix)

            colQuantite.addEventListener("change", () => {
                let totalLigne = prix * colQuantite.value;
                colTotal.textContent = totalLigne.toFixed(2) + " €";
                console.log()
            });

    }
}); 