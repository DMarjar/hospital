import React, { Component } from 'react';
import axios from 'axios';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';

class Consultorio extends Component {
    constructor(props) {
        super(props);
        this.state = {
            consultorios: []
        };
    }

    componentDidMount(){
        axios.get('http://localhost:8080/consultorio/get')
        .then(res => {
            this.setState({ consultorios: res.data.data});
        })
        .catch(error => {
            console.log(error);
        });
    }

    render() {
        const { consultorios } = this.state;
        return(
            <div className="card mt-3">
                <DataTable value={consultorios} className="p-datatable-gridlines">
                    <Column field="id" header="Id" />
                    <Column field="piso" header="Piso" />
                    <Column field="medico.nombre" header="Medico" />
                    <Column field="medico.especialidad" header="Especialidad" />
                </DataTable>
            </div>
        )
    }
}


export default Consultorio;