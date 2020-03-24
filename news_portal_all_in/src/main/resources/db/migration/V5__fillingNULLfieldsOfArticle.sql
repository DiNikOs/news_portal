-- @Author Farida Gareeva
-- Created 20/03/2020
--заполнение пустых полей у статей, т.к. там идет внутреннее соединение. Наверное нужно исправить на left
UPDATE newsportal.articles
	SET category_id=1 WHERE category_id is NULL;

UPDATE newsportal.articles
	SET status_id=1 WHERE status_id is NULL;