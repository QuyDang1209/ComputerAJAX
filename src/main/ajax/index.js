getAllComputer();
function getAllType(){
    $.ajax({
        type: "get",
        url:"http://localhost:8080/api/type",
        success: function (data){
        let arrType = data.map((t,i,arrt) =>{
            return `
            <option value="${t.id}">${t.type}</option>
            `;
            })
            $("#type").html(arrType.join(""))
            $("#type1").html(arrType.join(""))
        }
    })
}
function getAllTypeSelected(computer){
    $.ajax({
        type: "get",
        url:"http://localhost:8080/api/type",
        success: function (data){
            let arrType = data.map((t,i,arrt) =>{
                return `
            <option value="${t.id}" ${computer.type.id === t.id ? "selected" : ""}>${t.type}</option>
            `;
            })
            $("#type1").html(arrType.join(""))
        }
    })
}
function getAllComputer(){
    $.ajax({
        url: "http://localhost:8080/api/computer",
        type: "get",
        success: function (data){
            let arrComputer = data.map((c,i,arrc) =>{
                return `
                <tr>
                <td>${c.code}</td>
                <td>${c.name}</td>
                <td>${c.producer}</td>
                <td>${c.type.type}</td>
                <td>
                <a href="javascript:void(0)" onclick="computerDelete(${c.id})">Delete</a>
                <a href="javascript:void(0)" onclick="showFormUpdate(${c.id})">Update</a>
                </td>
                </tr>
            `;
            })
    $("#tb-computer").html(arrComputer.join(""))
        }
    });
}
function showFormCreate(){
    getAllType()
}
function createrNewComputer(){

    let code = $("#code").val()
    let name = $("#name").val()
    let producer = $("#producer").val()
    let type = $("#type").val()

    $.ajax({
        url: "http://localhost:8080/api/computer",
        type: "post",
        contentType: "application/json",
        data: JSON.stringify({
            "code": code,
            "name": name,
            "producer": producer,
            "type":{
                "id": type
            }

        }),
        success:
        getAllComputer

    })
}
function computerDelete(id){
    event.preventDefault()
    $.ajax({
        type: "delete",
        url: "http://localhost:8080/api/computer/" + id,
        success: function (){
            getAllComputer();
        }
    })
}

function showFormUpdate(id){
    $.ajax({
        type: "get",
        url: "http://localhost:8080/api/computer/" +id,
        success: function (data){

            let strFrmUpdate =  `
            <input id="code1" type="text" placeholder="" value="${data.code}"> <br>
            <input id="name1" type="text" placeholder="" value="${data.name}"> <br>
            <input id="producer1" type="text" placeholder="" value="${data.producer}"><br>
            <select name = "type" id="type1">
            </select> <br>
            <button type="button" onclick="updateComputer(${data.id})">Save</button>
            <button onclick="getAllComputer()">Cancel</button>
            `;
            $("#form-update").html(strFrmUpdate);
            $("#form-update").show();
            getAllTypeSelected(data)

        }
    })

}
function updateComputer(id){
    let code = $("#code1").val()
    let name = $("#name1").val()
    let producer = $("#producer1").val()
    let type = $("#type1").val()
    $.ajax({
        type: "put",
        url: "http://localhost:8080/api/computer/" + id,
        contentType: "application/json",
        data: JSON.stringify({
            "code": code,
            "name": name,
            "producer": producer,
            "type":{
                "id": type
            }

        }),
        success: function (){
            $("#form-update").hide();
            getAllComputer()
        }


    })
}