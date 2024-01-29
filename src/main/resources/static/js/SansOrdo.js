let patient = document.getElementById("patient")

let medicament = document.getElementById("medicament")

let listmedicament = document.querySelectorAll(".listmedicament")

let data = document.querySelectorAll("#datalistMedicament option")

let newRow = document.createElement("tr");

medicament.addEventListener("change", () => {
    if (medicament.value !== "") {
        let categorie;
        let prix;
        let nom = medicament.value;
    
        for (const row of data) {
            if (medicament.value === row.innerText) {
                categorie = row.getAttribute("cate_Med");
                prix = parseFloat(row.getAttribute("prix_Med"));
            }
        }
    
        newRow.innerHTML = `
            <td class="nomMed">${nom}</td>
            <td class="catMed">${categorie}</td>
            <td class="prixMed">${prix} €</td>
            <td class="quantite"><input value="1"></td>
            <td class="total">${prix} €</td>`;
    
        listmedicament.forEach(element => {
            element.appendChild(newRow.cloneNode(true));
        });
    
        // Fonction pour mettre à jour le total de la colonne
        function TotalColonneTotal() {
            let colQuantite = document.querySelectorAll(".quantite input");
            let colTotal = document.querySelectorAll(".total");
            let totalGlobal = 0;
    
            for (let i = 0; i < colQuantite.length; i++) {
                let totalLigne = prix * parseFloat(colQuantite[i].value);
                colTotal[i].textContent = totalLigne.toFixed(2) + " €";
                totalGlobal += totalLigne;
            }
    
            let sommeTotal = document.querySelector(".sommeTotal");
            sommeTotal.textContent = totalGlobal.toFixed(2) + " €";
        }
    
        // Appeler la fonction pour mettre à jour le total de la colonne
        TotalColonneTotal();
    
        // Ajouter un écouteur d'événements pour chaque champ de quantité
        let colQuantite = document.querySelectorAll(".quantite input");
        for (let i = 0; i < colQuantite.length; i++) {
            colQuantite[i].addEventListener("change", TotalColonneTotal);
        }

        // Vider le champ de médicament une fois que l'utilisateur a choisi un médicament
        medicament.value = "";
    }
}); 