
-- FUNCION NOMBRE MES --   dfdddfdgfdfgfdg

CREATE DEFINER=`root`@`localhost` FUNCTION `nombre_mes`(numeroMes INTEGER) RETURNS varchar(50) CHARSET utf8
    READS SQL DATA
    DETERMINISTIC
BEGIN

DECLARE mes VARCHAR (20) DEFAULT 'NO EXISTE';

CASE  numeroMes
WHEN 1 then set MES = 'ENERO';
WHEN 2 then set MES = 'FEBRERO';
WHEN 3 then set MES = 'MARZO';
WHEN 4 then set MES = 'ABRIL';
WHEN 5 then set MES = 'MAYO';
WHEN 6 then set MES = 'JUNIO';
WHEN 7 then set MES = 'JULIO';
WHEN 8 then set MES = 'AGOSTO';
WHEN 9 then set MES = 'SEPTIEMBRE';
WHEN 10 then set MES = 'OCTUBRE';
WHEN 11 then set MES = 'NOVIEMBRE';
WHEN 12 then set MES = 'DICIEMBRE';
ELSE
SET mes = concat(numeroMes, 'NO existe');
end case;
RETURN mes;
END


-- CONSULTA  CON FUNCION NOMBRE MES

SELECT     
	fecha, id_agente AS `id_agente`,
	YEAR(fecha) AS `anyo`,
	nombre_mes (MONTH(fecha)) AS `mes`,
	COUNT(0) AS `numero multas`,
	SUM(importe) AS `total importe`
FROM
	multa
GROUP BY id_agente , YEAR(fecha) , MONTH(fecha)