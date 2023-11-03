-- 코드를 입력하세요
SELECT CONCAT('/home/grep/src/', board.BOARD_ID, '/', file.FILE_ID, file.FILE_NAME, file.FILE_EXT) AS FILE_PATH
FROM USED_GOODS_BOARD AS board
LEFT JOIN USED_GOODS_FILE AS file ON board.BOARD_ID = file.BOARD_ID 
WHERE VIEWS = (SELECT VIEWS
                FROM USED_GOODS_BOARD
                ORDER BY VIEWS DESC 
                LIMIT 1)
ORDER BY FILE_ID DESC;