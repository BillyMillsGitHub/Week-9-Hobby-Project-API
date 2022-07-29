"use strict";

document.querySelector("body > form").addEventListener("submit", function (event) {
    event.preventDefault(); // turns off the page refresh/redirect
    // setTimeout(() => console.log("HEY!"), 1_000);

    console.log("THIS:", this);

    const data = {
        name: this.name.value,
        specialAbility: this.specialAbility.value,
        power: this.power.value,
        health: this.health.value,
        attack: this.attack.value,
        defence: this.defence.value,
        agility: this.agility.value,
        intelligence: this.intelligence.value
    }

    console.log("DATA:", data);

    axios.post("http://localhost:8080/createCharacterCreator", data)
        .then(res => {
            console.log("RES:", res);
            this.reset();
            this.name.focus();
            renderCharacterCreator();
        })
        .catch(err => console.error(err));
});

const output = document.querySelector("#output");

function renderCharacterCreator() {
    axios.get("http://localhost:8080/getCharacterCreator")
        .then(res => {
            console.log("characterCreator: ", res.data);
            output.innerHTML = "";
            for (let characterCreator of res.data) {
                const characterCreatorCol = document.createElement("div");
                characterCreatorCol.className = "col";

                const characterCreatorCard = document.createElement("div");
                characterCreatorCard.className = "card";
                characterCreatorCol.appendChild(characterCreatorCard);

                const characterCreatorDiv = document.createElement("div");
                characterCreatorDiv.className = "card-body";
                characterCreatorCard.appendChild(characterCreatorDiv);

                const characterCreatorName = document.createElement("input");
                characterCreatorName.setAttribute("required","");
                characterCreatorName.id = "name";
                characterCreatorName.value = characterCreator.name;
                characterCreatorDiv.appendChild(characterCreatorName);

              
                const characterCreatorSpecialAbility = document.createElement("p");
                characterCreatorSpecialAbility.setAttribute("required","");
                characterCreatorSpecialAbility.id = "specialAbility";
                characterCreatorSpecialAbility.innerText = "Special Ability: " + characterCreator.specialAbility;
                characterCreatorDiv.appendChild(characterCreatorSpecialAbility);

                const characterCreatorPower = document.createElement("p");
                characterCreatorPower.innerText = "Power:" + characterCreator.power;
                characterCreatorDiv.appendChild(characterCreatorPower);

                const characterCreatorHealth = document.createElement("p");
                characterCreatorHealth.innerText = " Health: " + characterCreator.health;
                characterCreatorDiv.appendChild(characterCreatorHealth);

                const characterCreatorAttack = document.createElement("p");
                characterCreatorAttack.innerText = "Attack: " + characterCreator.attack;
                characterCreatorDiv.appendChild(characterCreatorAttack);

                const characterCreatorDefence = document.createElement("p");
                characterCreatorDefence.innerText = "Defence: " + characterCreator.defence;
                characterCreatorDiv.appendChild(characterCreatorDefence);

                const characterCreatorAgility = document.createElement("p");
                characterCreatorAgility.innerText = "Agility: " + characterCreator.agility;
                characterCreatorDiv.appendChild(characterCreatorAgility);

                const characterCreatorIntelligence = document.createElement("p");
                characterCreatorIntelligence.innerText = "Intelligence: " + characterCreator.intelligence;
                characterCreatorDiv.appendChild(characterCreatorIntelligence);

                const characterCreatorDelete = document.createElement('button');
                characterCreatorDelete.innerText = "DELETE";
                characterCreatorDelete.className = "btn btn-outline-danger";
                characterCreatorDelete.addEventListener("click", () => {
                    console.log("CHARACTERCREATOR: ", characterCreator);
                    deleteCharacterCreator(characterCreator.id);
                });
                characterCreatorDiv.appendChild(characterCreatorDelete);

                const characterCreatorUpdate = document.createElement('button');
                characterCreatorUpdate.innerText = "UPDATE";
                characterCreatorUpdate.className = "btn btn=outline-warning";
                characterCreatorUpdate.addEventListener("click", () => {
                    console.log("CHARACTERCREATOR: ", characterCreator);
                    updateCharacterCreator(characterCreator.id);
                });
                characterCreatorDiv.appendChild(characterCreatorUpdate);
                output.appendChild(characterCreatorCol);

            }
        })
        .catch(err => console.error(err));
}

function deleteCharacterCreator(id) {
    axios.delete("http://localhost:8080/removeCharacterCreator/" + id)
        .then(res => {
            console.log("Delete successful");
            renderCharacterCreator();
        }).catch(err => console.error(err));
}

renderCharacterCreator();


const updateCharacterCreator = (id) => {

   const update = document.querySelector("#name", "#specialAbility", "#power", "#health", "#attack", "#defence", "#agility", "#intelligence").value;
    axios.patch("http://localhost:8080/updateCharacterCreator/" + id + "?name=" + name + "?specialAbility" + specialAbility + "?power" + power + "?health" + health + "?attack" + attack + "?defence" + defence + "?agility" + agility + "intelligence")
            .then(res => {
                console.log("Update successful");
                renderCharacterCreator();
            }).catch(err => console.log(err));
    


// const specialAbility = document.querySelector("#specialAbility");
//     axios.patch("http://localhost:8080/updateCharacterCreator/" + id + "?specialAbility=" + specialAbility)
//             .then(res => {
//                 console.log("Update successful");
//                 renderCharacterCreator();
//             }).catch(err => console.log(err));

//   "name", "#specialAbility", "#power", "#health", "#attack", "#defence", "#agility", "#intelligence")


    

        }