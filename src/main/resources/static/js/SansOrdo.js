let patient = document.getElementById("patient")

let medicament = document.getElementById("medicament")

let listmedicament = document.querySelectorAll(".listmedicament")

let data = document.querySelectorAll("#datalistMedicament option")
console.log(data)

medicament.addEventListener("change", () => {
    if(medicament.value !== "") {
        let categorie
        let prix
        let nom = medicament.value

        for (const row of data){
            if (medicament.value===row.innerText){
                console.log("ok")
                categorie = row.getAttribute("cate_Med");
                prix = row.getAttribute("prix_Med");
            }
        }
        
        let newRow = document.createElement("tr");

        newRow.innerHTML = `
            <td class="nomMed">${nom}</td>
            <td class="catMed">${categorie}</td>
            <td class="prixMed">${prix} €</td>`;

            listmedicament.forEach(element => {
                element.appendChild(newRow.cloneNode(true));
            });
    }
}); 