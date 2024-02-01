let patient = document.getElementById("patient")

let medicament = document.getElementById("medicament")

let listmedicament = document.querySelectorAll(".listmedicament")

let data = document.querySelectorAll("#datalistMedicament option")

let newRow = document.createElement("tr");
console.log(newRow)

medicament.addEventListener("change", () => {
    if (medicament.value !== "") {
        let nom = medicament.value;

        for (const row of data) {
            if (medicament.value === row.innerText) {
                let categorie = row.getAttribute("cate_Med");
                let prix = parseFloat(row.getAttribute("prix_Med"));

                newRow.innerHTML = `
                    <td class="nomMed">${nom}</td>
                    <td class="catMed">${categorie}</td>
                    <td class="prixMed" data-prix="${prix}">${prix} €</td>
                    <td class="quantite"><input value="1"></td>
                    <td class="total">${prix} €</td>`;

                listmedicament.forEach(element => {
                    element.appendChild(newRow.cloneNode(true));
                });

                let tabNom = [];

                // Fonction de mise à jour le total de la colonne
                function TotalColonneTotal() {
                    let colQuantite = document.querySelectorAll(".quantite input");
                    let colTotal = document.querySelectorAll(".total");
                    let totalGlobal = 0;

                    for (let i = 0; i < colQuantite.length; i++) {
                        let prixLigne = parseFloat(colTotal[i].closest("tr").querySelector(".prixMed").getAttribute("data-prix"));
                        let totalLigne = prixLigne * parseFloat(colQuantite[i].value);
                        colTotal[i].textContent = totalLigne.toFixed(2) + " €";
                        totalGlobal += totalLigne;

                        let nomMedicament = colTotal[i].closest("tr").querySelector(".nomMed").textContent;
                        tabNom.push(nomMedicament);
                    }
                        
                        // met les nom des medicament du tableau dans une varaible 
                    let sommeTotal = document.querySelector(".sommeTotal");
                    sommeTotal.textContent = totalGlobal.toFixed(2) + " €";
                }

                console.log(tabNom)
                TotalColonneTotal();

                let colQuantite = document.querySelectorAll(".quantite input");
                for (let i = 0; i < colQuantite.length; i++) {
                    colQuantite[i].addEventListener("change", TotalColonneTotal);
                }

                //champs vide apres la selection
                medicament.value = "";
            }
        }
    }
});