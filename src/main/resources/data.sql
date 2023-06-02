INSERT INTO tv (name, country, manufacturer, online_order, credit)
VALUES ('Sony-KD', 'Japan', 'Sony', true, true);
INSERT INTO tv_models (model_name, serial, colour, size, price, category, technology, in_stock, tv_id)
VALUES ('KD-55X75K', 'SNSONY001', 'black', 55, 77499, 'LED', 'Direct LED', true, 1);
INSERT INTO tv_models (model_name, serial, colour, size, price, category, technology, in_stock, tv_id)
VALUES ('KD43X72KPAEP', 'SNSONY002', 'white', 43, 91799, 'LED', 'Direct LED', true, 1);

INSERT INTO tv (name, country, manufacturer, online_order, credit)
VALUES ('LG LED', 'Russia', 'LG', true, true);
INSERT INTO tv_models (model_name, serial, colour, size, price, category, technology, in_stock, tv_id)
VALUES ('22TN410V-PZ', 'SNLG001', 'black', 22, 11999, 'LED', 'IPS', true, 2);
INSERT INTO tv_models (model_name, serial, colour, size, price, category, technology, in_stock, tv_id)
VALUES ('24LP451V-PZ', 'SNLG002', 'white', 24, 12999, 'LED', 'Edge LED', true, 2);

INSERT INTO tv (name, country, manufacturer, online_order, credit)
VALUES ('LED PHILIPS', 'Netherlands', 'Philips', true, true);
INSERT INTO tv_models (model_name, serial, colour, size, price, category, technology, in_stock, tv_id)
VALUES ('Philips 32PHS5505/60', 'SNPHILIPS001', 'black', 32, 9999, 'LED', 'Direct LED', true, 3);
INSERT INTO tv_models (model_name, serial, colour, size, price, category, technology, in_stock, tv_id)
VALUES ('Philips 32PHS5507/60', 'SNPHILIPS002', 'white', 32, 9999, 'LED', 'Direct LED', true, 3);

INSERT INTO hoover (name, country, manufacturer, online_order, credit)
VALUES ('Bosh BG', 'Poland', 'Bosh', true, true);
INSERT INTO hoover_models (model_name, serial, colour, size, price, dust_capacity, modes_count, in_stock, hoover_id)
VALUES ('Bosch BGS7PET', 'SNBOSH001', 'red', 10, 19699, 3, 4, true, 1);
INSERT INTO hoover_models (model_name, serial, colour, size, price, dust_capacity, modes_count, in_stock, hoover_id)
VALUES ('Bosch BGLS42230', 'SNBOSH002', 'black', 10, 9399, 5, 2, true, 1);

INSERT INTO hoover (name, country, manufacturer, online_order, credit)
VALUES ('LG VC', 'Vietnam', 'LG', true, true);
INSERT INTO hoover_models (model_name, serial, colour, size, price, dust_capacity, modes_count, in_stock, hoover_id)
VALUES ('LG VC83209UHA Kompressor', 'SNLGVC001', 'red', 6, 12999, 1, 2, true, 2);
INSERT INTO hoover_models (model_name, serial, colour, size, price, dust_capacity, modes_count, in_stock, hoover_id)
VALUES ('LG VC5420NHTW', 'SNLGVC002', 'purple', 4, 8999, 1, 3, true, 2);

INSERT INTO hoover (name, country, manufacturer, online_order, credit)
VALUES ('Thomas DryBox', 'Germany', 'Thomas', true, true);
INSERT INTO hoover_models (model_name, serial, colour, size, price, dust_capacity, modes_count, in_stock, hoover_id)
VALUES ('Thomas DryBox Amfibia', 'SNTHMSVC001', 'black', 8, 32799, 3, 10, true, 3);
INSERT INTO hoover_models (model_name, serial, colour, size, price, dust_capacity, modes_count, in_stock, hoover_id)
VALUES ('Thomas 788599 DRYBOX AMFIBIA FAMILY', 'SNTHMSVC002', 'black', 7, 33999, 4, 12, true, 3);

INSERT INTO refrigerator (name, country, manufacturer, online_order, credit)
VALUES ('Electrolux RN', 'Turkey', 'Electrolux', true, true);
INSERT INTO refrigerator_models (model_name, serial, colour, size, price, doors_count, compressor_type, in_stock, refrigerator_id)
VALUES ('Electrolux RNC7ME34W2', 'SNELTFR001', 'white', 73, 66699, 2, 'Inverter', true, 1);
INSERT INTO refrigerator_models (model_name, serial, colour, size, price, doors_count, compressor_type, in_stock, refrigerator_id)
VALUES ('Electrolux RNC7ME32X2', 'SNELTFR002', 'silver', 75, 80499, 2, 'double', true, 1);

INSERT INTO refrigerator (name, country, manufacturer, online_order, credit)
VALUES ('ATLANT MX', 'Belorussia', 'Atlant', true, true);
INSERT INTO refrigerator_models (model_name, serial, colour, size, price, doors_count, compressor_type, in_stock, refrigerator_id)
VALUES ('ATLANT МХ-2822-80', 'SNATLFR001', 'white', 63, 45699, 2, 'simple', true, 2);
INSERT INTO refrigerator_models (model_name, serial, colour, size, price, doors_count, compressor_type, in_stock, refrigerator_id)
VALUES ('ATLANT МХ-2823-80', 'SNATLFR002', 'white', 62, 42399, 2, 'double', true, 2);

INSERT INTO refrigerator (name, country, manufacturer, online_order, credit)
VALUES ('Hotpoint-Ariston HTD', 'Italy', 'Hotpoint-Ariston', true, true);
INSERT INTO refrigerator_models (model_name, serial, colour, size, price, doors_count, compressor_type, in_stock, refrigerator_id)
VALUES ('Hotpoint-Ariston HTD 4180 W', 'SNARTFR001', 'white', 56, 33999, 2, 'simple', true, 3);
INSERT INTO refrigerator_models (model_name, serial, colour, size, price, doors_count, compressor_type, in_stock, refrigerator_id)
VALUES ('Hotpoint-Ariston HTD 4180 M', 'SNARTFR002', 'beige', 60, 34999, 2, 'double', true, 3);

INSERT INTO smartphone (name, country, manufacturer, online_order, credit)
VALUES ('Apple iphone', 'China', 'Apple', true, true);
INSERT INTO smartphone_models (model_name, serial, colour, size, price, memory, cameras_count, in_stock, smartphone_id)
VALUES ('Apple iPhone SE 2022', 'SNAPLSP001', 'gold', 15, 38499, '64 Gb', 3, true, 1);
INSERT INTO smartphone_models (model_name, serial, colour, size, price, memory, cameras_count, in_stock, smartphone_id)
VALUES ('Apple iPhone 11', 'SNAPLSP002', 'black', 18, 46899, '128 Gb', 2, true, 1);

INSERT INTO smartphone (name, country, manufacturer, online_order, credit)
VALUES ('Honor X', 'China', 'Honor', true, true);
INSERT INTO smartphone_models (model_name, serial, colour, size, price, memory, cameras_count, in_stock, smartphone_id)
VALUES ('HONOR X5', 'SNHNRSP001', 'gold', 14, 7999, '64 Gb', 3, true, 2);
INSERT INTO smartphone_models (model_name, serial, colour, size, price, memory, cameras_count, in_stock, smartphone_id)
VALUES ('HONOR X6', 'SNHNRSP002', 'black', 15, 8999, '64 Gb', 2, true, 2);

INSERT INTO smartphone (name, country, manufacturer, online_order, credit)
VALUES ('Samsung Galaxy', 'China', 'Samsung', true, true);
INSERT INTO smartphone_models (model_name, serial, colour, size, price, memory, cameras_count, in_stock, smartphone_id)
VALUES ('Samsung Galaxy A04', 'SNSMSSP001', 'gold', 14, 10499, '64 Gb', 2, true, 3);
INSERT INTO smartphone_models (model_name, serial, colour, size, price, memory, cameras_count, in_stock, smartphone_id)
VALUES ('Samsung Galaxy A03', 'SNSMSSP003', 'black', 15, 8999, '32 Gb', 2, true, 3);

INSERT INTO computer (name, country, manufacturer, online_order, credit)
VALUES ('Lenovo IdeaPad', 'China', 'Lenovo', true, true);
INSERT INTO computer_models (model_name, serial, colour, size, price, category, processor_type, in_stock, computer_id)
VALUES ('Lenovo IdeaPad 3 15IGL05', 'SNLNVC001', 'gray', 14, 25999, 'laptop', 'x86', true, 1);
INSERT INTO computer_models (model_name, serial, colour, size, price, category, processor_type, in_stock, computer_id)
VALUES ('Lenovo IdeaPad 1 14ADA05', 'SNLNVC002', 'black', 15, 29999, 'notebook', 'ARM', true, 1);

INSERT INTO computer (name, country, manufacturer, online_order, credit)
VALUES ('HP Laptop', 'Taiwan', 'HP', true, true);
INSERT INTO computer_models (model_name, serial, colour, size, price, category, processor_type, in_stock, computer_id)
VALUES ('HP Laptop 15s-fq3008ur', 'SNHPC001', 'gray', 15, 32999, 'laptop', 'x86', true, 2);
INSERT INTO computer_models (model_name, serial, colour, size, price, category, processor_type, in_stock, computer_id)
VALUES ('HP Laptop 15s-eq1427ur', 'SNHPC002', 'black', 17, 42999, 'notebook', 'ARM', true, 2);

INSERT INTO computer (name, country, manufacturer, online_order, credit)
VALUES ('Apple MacBook', 'China', 'Apple', true, true);
INSERT INTO computer_models (model_name, serial, colour, size, price, category, processor_type, in_stock, computer_id)
VALUES ('Apple MacBook Air', 'SNAPLC001', 'gold', 13, 79099, 'laptop', 'x86', true, 3);
INSERT INTO computer_models (model_name, serial, colour, size, price, category, processor_type, in_stock, computer_id)
VALUES ('Apple MacBook Pro', 'SNAPLC002', 'silver', 13, 110399, 'notebook', 'ARM', true, 3);