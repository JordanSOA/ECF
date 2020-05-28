--
-- PostgreSQL database dump
--

-- Dumped from database version 11.4
-- Dumped by pg_dump version 11.4

-- Started on 2020-05-28 18:45:27

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 205 (class 1259 OID 18144)
-- Name: messages; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.messages (
    id integer NOT NULL,
    body text,
    author_id integer NOT NULL,
    next_message_id integer NOT NULL,
    created time with time zone,
    message_id integer,
    user_id integer
);


ALTER TABLE public.messages OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 18140)
-- Name: messages_author_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.messages_author_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.messages_author_id_seq OWNER TO postgres;

--
-- TOC entry 2854 (class 0 OID 0)
-- Dependencies: 203
-- Name: messages_author_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.messages_author_id_seq OWNED BY public.messages.author_id;


--
-- TOC entry 202 (class 1259 OID 18138)
-- Name: messages_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.messages_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.messages_id_seq OWNER TO postgres;

--
-- TOC entry 2855 (class 0 OID 0)
-- Dependencies: 202
-- Name: messages_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.messages_id_seq OWNED BY public.messages.id;


--
-- TOC entry 204 (class 1259 OID 18142)
-- Name: messages_next_message_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.messages_next_message_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.messages_next_message_id_seq OWNER TO postgres;

--
-- TOC entry 2856 (class 0 OID 0)
-- Dependencies: 204
-- Name: messages_next_message_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.messages_next_message_id_seq OWNED BY public.messages.next_message_id;


--
-- TOC entry 201 (class 1259 OID 18130)
-- Name: threads; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.threads (
    id integer NOT NULL,
    first_message_id integer NOT NULL,
    owner_id integer NOT NULL,
    created timestamp without time zone
);


ALTER TABLE public.threads OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 18126)
-- Name: thread_first_message_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.thread_first_message_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.thread_first_message_id_seq OWNER TO postgres;

--
-- TOC entry 2857 (class 0 OID 0)
-- Dependencies: 199
-- Name: thread_first_message_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.thread_first_message_id_seq OWNED BY public.threads.first_message_id;


--
-- TOC entry 198 (class 1259 OID 18124)
-- Name: thread_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.thread_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.thread_id_seq OWNER TO postgres;

--
-- TOC entry 2858 (class 0 OID 0)
-- Dependencies: 198
-- Name: thread_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.thread_id_seq OWNED BY public.threads.id;


--
-- TOC entry 200 (class 1259 OID 18128)
-- Name: thread_owner_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.thread_owner_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.thread_owner_id_seq OWNER TO postgres;

--
-- TOC entry 2859 (class 0 OID 0)
-- Dependencies: 200
-- Name: thread_owner_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.thread_owner_id_seq OWNED BY public.threads.owner_id;


--
-- TOC entry 197 (class 1259 OID 18115)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    birthdate date NOT NULL,
    email character varying(512) NOT NULL,
    firstname character varying(512) NOT NULL,
    id integer NOT NULL,
    lastname character varying(512) NOT NULL,
    last_known_presence timestamp with time zone,
    password character varying(512) NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 18113)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- TOC entry 2860 (class 0 OID 0)
-- Dependencies: 196
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- TOC entry 2711 (class 2604 OID 18147)
-- Name: messages id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.messages ALTER COLUMN id SET DEFAULT nextval('public.messages_id_seq'::regclass);


--
-- TOC entry 2712 (class 2604 OID 18148)
-- Name: messages author_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.messages ALTER COLUMN author_id SET DEFAULT nextval('public.messages_author_id_seq'::regclass);


--
-- TOC entry 2713 (class 2604 OID 18149)
-- Name: messages next_message_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.messages ALTER COLUMN next_message_id SET DEFAULT nextval('public.messages_next_message_id_seq'::regclass);


--
-- TOC entry 2708 (class 2604 OID 18133)
-- Name: threads id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.threads ALTER COLUMN id SET DEFAULT nextval('public.thread_id_seq'::regclass);


--
-- TOC entry 2709 (class 2604 OID 18134)
-- Name: threads first_message_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.threads ALTER COLUMN first_message_id SET DEFAULT nextval('public.thread_first_message_id_seq'::regclass);


--
-- TOC entry 2710 (class 2604 OID 18135)
-- Name: threads owner_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.threads ALTER COLUMN owner_id SET DEFAULT nextval('public.thread_owner_id_seq'::regclass);


--
-- TOC entry 2707 (class 2604 OID 18118)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- TOC entry 2721 (class 2606 OID 18154)
-- Name: messages messages_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.messages
    ADD CONSTRAINT messages_pkey PRIMARY KEY (id);


--
-- TOC entry 2719 (class 2606 OID 18137)
-- Name: threads thread_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.threads
    ADD CONSTRAINT thread_pkey PRIMARY KEY (id);


--
-- TOC entry 2715 (class 2606 OID 18188)
-- Name: users uniqueemail; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT uniqueemail UNIQUE (email);


--
-- TOC entry 2717 (class 2606 OID 18123)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2725 (class 2606 OID 18172)
-- Name: messages fk36ijgmqdb00ursn8jpqh545q6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.messages
    ADD CONSTRAINT fk36ijgmqdb00ursn8jpqh545q6 FOREIGN KEY (message_id) REFERENCES public.messages(id);


--
-- TOC entry 2724 (class 2606 OID 18155)
-- Name: messages fk_messages_users_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.messages
    ADD CONSTRAINT fk_messages_users_id FOREIGN KEY (author_id) REFERENCES public.users(id);


--
-- TOC entry 2723 (class 2606 OID 18165)
-- Name: threads fk_threads_messages-ids; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.threads
    ADD CONSTRAINT "fk_threads_messages-ids" FOREIGN KEY (first_message_id) REFERENCES public.messages(id);


--
-- TOC entry 2722 (class 2606 OID 18160)
-- Name: threads fk_threads_users_ids; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.threads
    ADD CONSTRAINT fk_threads_users_ids FOREIGN KEY (owner_id) REFERENCES public.users(id);


--
-- TOC entry 2727 (class 2606 OID 18182)
-- Name: messages fkc178xl191un3k711bs5aetej2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.messages
    ADD CONSTRAINT fkc178xl191un3k711bs5aetej2 FOREIGN KEY (next_message_id) REFERENCES public.messages(id);


--
-- TOC entry 2726 (class 2606 OID 18177)
-- Name: messages fkpsmh6clh3csorw43eaodlqvkn; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.messages
    ADD CONSTRAINT fkpsmh6clh3csorw43eaodlqvkn FOREIGN KEY (user_id) REFERENCES public.users(id);


-- Completed on 2020-05-28 18:45:31

--
-- PostgreSQL database dump complete
--

