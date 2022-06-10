/*
Created: 10.06.2022
Modified: 10.06.2022
Model: PostgreSQL 12
Database: PostgreSQL 12
*/

-- Create tables section -------------------------------------------------

-- Table patient

CREATE TABLE "patient"
(
    "id" BigSerial NOT NULL,
    "first_name" Text NOT NULL,
    "second_name" Text NOT NULL,
    "third_name" Text,
    "phone" Text,
    "address" Text
)
    WITH (
        autovacuum_enabled=true)
;

ALTER TABLE "patient" ADD CONSTRAINT "PK_patient" PRIMARY KEY ("id")
;

alter sequence patient_id_seq restart with 1;

INSERT INTO public.patient (id, first_name, second_name, third_name, phone, address) VALUES (default, 'Иванов', 'Иван', 'Иванович', '88888888888', 'Балтийская 10');
INSERT INTO public.patient (id, first_name, second_name, third_name, phone, address) VALUES (default, 'Степанова', 'Ирина', 'Олеговна', '89139131313', 'Малахова 15');
INSERT INTO public.patient (id, first_name, second_name, third_name, phone, address) VALUES (default, 'Альхов', 'Вадим', 'Петрович', '88005553535', 'Юрина 5');
INSERT INTO public.patient (id, first_name, second_name, third_name, phone, address) VALUES (default, 'Степаненко', 'Наталья', 'Алексеевна', '89998887766', 'Юрина 225');
