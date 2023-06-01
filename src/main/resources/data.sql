INSERT INTO hw_type (hw_type) VALUES ('tv');
INSERT INTO hw_type (hw_type) VALUES ('hoover');
INSERT INTO hw_type (hw_type) VALUES ('refrigerator');
INSERT INTO hw_type (hw_type) VALUES ('smartphone');
INSERT INTO hw_type (hw_type) VALUES ('computer');

INSERT INTO hw_reg (hw_type_id, name, country, manufacturer, online_order, credit)
VALUES (1, 'Sony XPS', 'Japan', 'Sony', true, true);
INSERT INTO hw_reg (hw_type_id, name, country, manufacturer, online_order, credit)
VALUES (1, 'Philips Ambilight', 'Netherlands', 'Philips', true, true);

INSERT INTO tv_models (model_name, serial, colour, size, price, category, technology, in_stock, hw_reg_id)
VALUES ('STV-XPS-1000', 'SNXPS0001', 'black', 55, 99999, 'LCD', 'LED', true, 1);
INSERT INTO tv_models (model_name, serial, colour, size, price, category, technology, in_stock, hw_reg_id)
VALUES ('STV-XPS-5000', 'SNXPS0002', 'black', 60, 230000, 'LCD', 'LED', true, 1);