-- @Author Farida Gareeva
-- Created 04/04/2020
-- Создано представление view comment_details в базе данных
-- для удобства получения детальной информации по комментариям к статьям.
-- В этой таблице собраны все необходимые данные для вывода.
CREATE VIEW comment_details as (SELECT  comment_details.comment_id as id,comment_details.created,comment_details.text,
comment_details.username as author,comment_details.article_id, comment_details.user_id,
tab_likes_dislikes.likes, tab_likes_dislikes.dislikes from
(SELECT COALESCE(tab_likes.comment_id,tab_dislikes.comment_id) as comment_id,
	COALESCE(tab_likes.sum,0) as likes,
	COALESCE(tab_dislikes.sum,0) as dislikes from (SELECT comment_id, sum(value)
	FROM newsportal.comment_likes where value = 1 group by comment_id) as tab_likes
full join
(SELECT comment_id, sum(value)
	FROM newsportal.comment_likes where value = -1 group by comment_id) as tab_dislikes

	on tab_likes.comment_id = tab_dislikes.comment_id) as tab_likes_dislikes

right join
	(select users.username, comments.created, comments.text, comments.id as comment_id, comments.article_id,comments.user_id
	from newsportal.comments
	inner join newsportal.users
	on comments.user_id = users.id
	) as comment_details

	on tab_likes_dislikes.comment_id = comment_details.comment_id);
