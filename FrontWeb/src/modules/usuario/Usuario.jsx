import React, { Component } from 'react';
import axios from 'axios';
import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';

class Usuario    extends Component {
    constructor(props) {
        super(props);
        this.state = {
            usuarios: []
        };
    }

    componentDidMount(){
        axios.get('http://18.222.153.46:8080/hospital/usuario/')
        .then(res => {
            this.setState({ usuarios: res.data.data });
        })
        .catch(error => {
            console.log(error);
        })
    }

    render() {
        const {usuarios} =this.state;
        return(
            <div className='card mt-3'>
                <DataTable value={usuarios} className='p-datatable-gridlines'>
                    <Column field='id' header="No." />
                    <Column field='username' header="Username" />
                    <Column field='role' header="Role" />
                </DataTable>
            </div>
        )
    }
}

export default Usuario;