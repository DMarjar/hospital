# Hospital
Proyecto de Sistema de Gestion de Hospital

Inserciones para pruebas de la base de datos:

db.usuarios.insertMany([
    {
        "id": "1",
        "username": "admin",
        "password": "admin123",
        "role": "ADMIN"
    },
    {
        "id": "2",
        "username": "doctor",
        "password": "doctor123",
        "role": "USER"    
    }
])

db.medicinas.insertMany([
    {
        "id": "1",
        "nombre": "Paracetamol",
        "presentacion": "Pastillas",
        "cantidad": 100
    },
    {
        "id": "2",
        "nombre": "Ibuprofeno",
        "presentacion": "Tabletas",
        "cantidad": 45
    },
    {
        "id": "3",
        "nombre": "Aspirina",
        "presentacion": "Pastillas",
        "cantidad": 20
    },
    {
        "id": "4",
        "nombre": "Histiacil",
        "presentacion": "Jarabe",
        "cantidad": 50
    }
])

db.medicos.insertMany([
    {
        "id": "1",
        "nombre": "Juan",
        "apellidos": "Perez Sanchez",
        "sexo": "HOMBRE",
        "edad": 30,
        "especialidad": "Neurologia"
    },
    {
        "id": "2",
        "nombre": "Maria",
        "apellidos": "Gomez Lopez",
        "sexo": "MUJER",
        "edad": 25,
        "especialidad": "Cardiologia"
    },
    {
        "id": "3",
        "nombre": "Pedro",
        "apellidos": "Gonzalez Perez",
        "sexo": "HOMBRE",
        "edad": 40,
        "especialidad": "Oftalmologia"
    },
    {
        "id": "4",
        "nombre": "Luis",
        "apellidos": "Garcia Suarez",
        "sexo": "HOMBRE",
        "edad": 59,
        "especialidad": "Ginecologia"
    }
])

db.pacientes.insertMany([
    {
        "id": "1",
        "nombre": "Alan",
        "apellidos": "Hernandez Moreno",
        "numeroSeguro": "123456789",
        "sexo": "HOMBRE",
        "alturaMetros": 1.70,
        "pesoKg": 70,
        "edad": 28
    },
    {
        "id": "2",
        "nombre": "Luisa",
        "apellidos": "Garcia Suarez",
        "numeroSeguro": "987654321",
        "sexo": "MUJER",
        "alturaMetros": 1.60,
        "pesoKg": 50,
        "edad": 52
    },
    {
        "id": "3",
        "nombre": "Carlos",
        "apellidos": "Marquez Sosa",
        "numeroSeguro": "555555555",
        "sexo": "HOMBRE",
        "alturaMetros": 1.84,
        "pesoKg": 80,
        "edad": 35
    },
    {
        "id": "4",
        "nombre": "Anastasia",
        "apellidos": "Vladimirovna Romanova",
        "numeroSeguro": "111111111",
        "sexo": "MUJER",
        "alturaMetros": 1.75,
        "pesoKg": 60,
        "edad": 27
    }
])

db.consultorios.insertMany([
    {
        "id": "1",
        "piso": "Planta baja",
        "medico": {
            "id": "1",
            "nombre": "Juan",
            "apellidos": "Perez Sanchez",
            "sexo": "HOMBRE",
            "edad": 30,
            "especialidad": "Neurologia"
        }
    },
    {
        "id": "2",
        "piso": "Primer piso",
        "medico": {
            "id": "2",
            "nombre": "Maria",
            "apellidos": "Gomez Lopez",
            "sexo": "MUJER",
            "edad": 25,
            "especialidad": "Cardiologia"
        }
    },
    {
        "id": "3",
        "piso": "Segundo piso",
        "medico": {
            "id": "3",
            "nombre": "Pedro",
            "apellidos": "Gonzalez Perez",
            "sexo": "HOMBRE",
            "edad": 40,
            "especialidad": "Oftalmologia"
        }
    }
])

db.prescripciones.insertMany([
    {
        "id": "1",
        "fechaPrescripcion": "2020-01-01",
        "medicina": {
            "id": "1",
            "nombre": "Paracetamol",
            "presentacion": "Pastillas",
            "cantidad": 100
        },
        "duracionTratamiento": "2 semanas",
        "indicaciones": "Tomar 1 pastilla cada 8 horas",
        "paciente": {
            "id": "1",
            "nombre": "Alan",
            "apellidos": "Hernandez Moreno",
            "numeroSeguro": "123456789",
            "sexo": "HOMBRE",
            "alturaMetros": 1.70,
            "pesoKg": 70,
            "edad": 28
        },
        "medico": {
            "id": "1",
            "nombre": "Juan",
            "apellidos": "Perez Sanchez",
            "sexo": "HOMBRE",
            "edad": 30,
            "especialidad": "Neurologia"
        },
        "consultorio": {
            "id": "1",
            "piso": "Planta baja",
            "medico": {
                "id": "1",
                "nombre": "Juan",
                "apellidos": "Perez Sanchez",
                "sexo": "HOMBRE",
                "edad": 30,
                "especialidad": "Neurologia"
            }
        }
    },
    {
        "id": "2",
        "fechaPrescripcion": "2020-01-05",
        "medicina": {
            "id": "2",
            "nombre": "Ibuprofeno",
            "presentacion": "Tabletas",
            "cantidad": 45
        },
        "duracionTratamiento": "1 semana",
        "indicaciones": "Tomar 1 tableta cada 12 horas",
        "paciente": {
            "id": "2",
            "nombre": "Luisa",
            "apellidos": "Garcia Suarez",
            "numeroSeguro": "987654321",
            "sexo": "MUJER",
            "alturaMetros": 1.60,
            "pesoKg": 50,
            "edad": 52
        },
        "medico": {
            "id": "2",
            "nombre": "Maria",
            "apellidos": "Gomez Lopez",
            "sexo": "MUJER",
            "edad": 25,
            "especialidad": "Cardiologia"
        },
        "consultorio": {
            "id": "2",
            "piso": "Primer piso",
            "medico": {
                "id": "2",
                "nombre": "Maria",
                "apellidos": "Gomez Lopez",
                "sexo": "MUJER",
                "edad": 25,
                "especialidad": "Cardiologia"
            }
        }
    }
])
