-- NECESSARY TO TEST SPIDERHUB

INSERT INTO public.user_role(
	id, isdelete, userrole)
	VALUES (1000, 'no', 'ROLE_ADMIN');
INSERT INTO public.user_role(
	id, isdelete, userrole)
	VALUES (1001, 'no', 'ROLE_MANAGER');
INSERT INTO public.user_role(
	id, isdelete, userrole)
	VALUES (1002, 'no', 'ROLE_MEMBER');